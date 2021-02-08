
import os, sys, shutil, re
import subprocess as sub


# base_path = 'W:\\RTL\\wswg_rnd\\lf_project\\New_Clip\\'
base_path = ''

def make_clip():
    print("start make clip!")
    src_dir = sys.argv[1]
    path = base_path + src_dir + os.sep
    searched = [s for s in sys.argv if ops_mc["-cliprange"] in s]#-cliprange_1_41

    rg_f = 1
    rg_l = 41

    if 0 < len(searched):
        clip_ranges = [int(i) for i in searched[0].split('_') if i.isdigit()]        
        if 1 < len(clip_ranges) and clip_ranges[0] < clip_ranges[1]:
            rg_f, rg_l = clip_ranges[0], clip_ranges[1] + 1

    for i in range(rg_f, rg_l):
        clip_name = 'clip%03d'%i
        os.makedirs(path + clip_name, exist_ok=True)
    print("done!")


def new_rename():
    print("start rename!")
    src_dir = sys.argv[1]
    path = base_path + src_dir
    clip_list = os.listdir(path)
    # clip_list = ["clip037"]

    while path[-1] == os.sep:        
        path = path[:-1]

    if ops_rn["-onlyclip"] in sys.argv or ops_rn["-oc"] in sys.argv:
        print("only clip rename")
        clip_list = [s for s in clip_list if "clip" in s]
    elif ops_rn["-piece"] in sys.argv:     
        piece = path.split(os.sep)[-1]
        # piece_num = 0
        # for s in path.split(os.sep):
        #     if s != "":
        #         piece = s
        #         piece_num += 1


        print("just rename " + piece + "!")

        clip_list.clear()
        clip_list.append(piece)
        path = os.sep.join(path.split(os.sep)[:-1])

    path += os.sep
    print("rename target list : ", clip_list)
    print(path)
    
    for clip in clip_list:
        cameras = os.listdir(path + clip)
        for camera in cameras:
            c_path = path + clip + os.sep + camera
            c_new_name = clip + '_' + camera.split('_')[-1]
            if ops_rn["-undo"] in sys.argv:
                c_new_name = camera.split('_')[-1]

            img_list = os.listdir(c_path)
            for img in img_list:
                i_path = c_path + os.sep + img
                tail_name = img.split('_')[-1]
                if ops_rn["-swap_20_24"] in sys.argv:
                    if tail_name == "020.png":
                        tail_name = "024.png"
                    elif tail_name == "024.png":
                        tail_name = "020.png"

                i_new_name = c_new_name + '_' + tail_name 
                
                if ops_rn["-undo"] in sys.argv:
                    i_new_name = tail_name              

                print(i_path,"\t->\t",i_new_name)
                
                if ops_rn["-old"] in sys.argv:
                    command = 'rename {} {}'.format(i_path, i_new_name)
                    sub.Popen(command, shell=True).wait()
                else:
                    os.rename(i_path, c_path + os.sep + i_new_name)

            print(c_path,"\t->\t",c_new_name)
            if ops_rn["-old"] in sys.argv:
                command = 'rename {} {}'.format(c_path, c_new_name)
                sub.Popen(command, shell=True).wait()
            else:
                os.rename(c_path, path + clip + os.sep + c_new_name)
    print("done!")


def frameTimeLineCorrecter():                  
    clip_path = sys.argv[1]
    frames = os.listdir(clip_path)
    first_frame_path = clip_path + os.sep + frames[0]

    if len(os.listdir(first_frame_path)) == 0 \
        or not os.path.isfile(first_frame_path + os.sep + os.listdir(first_frame_path)[0]):
        print("올바르지 않은 클립 경로입니다! <" + clip_path + ">")
        exit()

    print("start frameTimeLineCorrecter!")
    

    # print(frames)
    weight_dirname = 0
    if ops_crt["-down"] in sys.argv or ops_crt["-dn"] in sys.argv:
        weight_dirname = -1
        frames.sort(key=lambda s: (int(s.split('_')[-1])))
        # sorted(frames, key=int)
    elif ops_crt["-up"] in sys.argv:
        weight_dirname = 1
        frames.sort(key=lambda s: (int(s.split('_')[-1])), reverse=True)
        # sorted(frames)
    else:
        print("does not input direction!")
        exit()
    # print(frames)

    pre_path = "none"
    for frame in frames:
        f_path = clip_path + os.sep + frame
        # f_new_name = clip_path + '_' + frame.split('_')[-1]

        img_list = os.listdir(f_path)            
        tmp_img_list = []
        if ops_crt["-wn1"] in sys.argv:
            searched_imgs = [s for s in img_list if "000.png" in s]
            if 0 < len(searched_imgs):
                idx = img_list.index(searched_imgs[0])
                tmp_img_list += img_list[idx: idx+8]
        if ops_crt["-wn2"] in sys.argv:
            searched_imgs = [s for s in img_list if "008.png" in s]
            if 0 < len(searched_imgs):
                idx = img_list.index(searched_imgs[0])
                tmp_img_list += img_list[idx: idx+8]
        if ops_crt["-wn3"] in sys.argv:
            searched_imgs = [s for s in img_list if "016.png" in s]
            if 0 < len(searched_imgs):
                idx = img_list.index(searched_imgs[0])
                tmp_img_list += img_list[idx: idx+8]
        if ops_crt["-wn4"] in sys.argv:
            searched_imgs = [s for s in img_list if "024.png" in s]
            if 0 < len(searched_imgs):
                idx = img_list.index(searched_imgs[0])
                tmp_img_list += img_list[idx:]

        img_list = tmp_img_list
        # print(img_list)
        if len(img_list) <= 0:
            print("해당 이미지가 없습니다! : [" + f_path + "]")
            # exit()

        for img in img_list:
            i_path = f_path + os.sep + img
            i_new_name = f_path
            if len(img.split('_')) > 1:
                newnamelist = img.split('_')
                newnamelist[-2] = str(int(newnamelist[-2]) + weight_dirname)
                i_new_name = '_'.join(newnamelist)

                print("rename target : ", img," >>>>>RENAMING!>>>>> ",i_new_name)
                
                os.rename(i_path, f_path + os.sep + i_new_name)
                i_path = f_path + os.sep + i_new_name
           

            if pre_path == 'none':
                first_dir = frame
                new_folder_name = "_".join(first_dir.split('_')[:-1])
                if len(new_folder_name) > 0:
                    new_folder_name += "_"
                new_folder_name = new_folder_name + str(int(first_dir.split('_')[-1]) + weight_dirname)

                pre_path = clip_path + os.sep + new_folder_name 
                print("create new folder : [" + pre_path + "]")
                os.makedirs(pre_path, exist_ok=True)

                    
            print(i_path,"\n\t >>>>>MOVE!>>>>> ", pre_path)
            shutil.move(i_path, pre_path)
            if len(os.listdir(f_path)) == 0:
                print("del empty folder! : [" + f_path + "]")
                os.rmdir(f_path)


        pre_path = f_path
    
    print("done!")


# 가능 옵션
# options = {"-correct": "-correct", "-crt" : "-crt"}
ops_crt = {"-down":"-down", "-dn":"-dn", "-up":"-up", "-wn1":"-wn1", "-wn2":"-wn2", "-wn3":"-wn3", "-wn4":"-wn4"}
ops_rn = {"-onlyclip":"-onlyclip", "-oc":"-oc", "-piece":"-piece","-undo":"-undo","-swap_20_24":"-swap_20_24", "-old":"-old"}
ops_mc = {"-cliprange":"-cliprange"}


if "-help" in sys.argv:
    print()
    print("valid options '-correct' '-crt'(타임라인수정):", ops_crt.values())
    print("valid options '-rename' '-rn'(리네이밍):", ops_rn.values())
    print("valid options '-mkclip' '-mc'(클립메이커 default 1~40):", ops_mc.values())
    print()
elif os.path.isdir(sys.argv[1]):    
    sel_op = {}
    act_func = print("")
    if "-correct" == sys.argv[2] or "-crt" == sys.argv[2]:
        sel_op = ops_crt
        act_func = frameTimeLineCorrecter
    elif "-rename" == sys.argv[2] or "-rn"  == sys.argv[2]:
        sel_op = ops_rn
        act_func = new_rename
    elif "-mkclip" == sys.argv[2] or "-mc" == sys.argv[2]:
        sel_op = ops_mc
        act_func = make_clip
    else:
        print("not exist option!!")
        exit()
    
    # print(sel_op)
    wrongOps = [userop for userop in sys.argv[3:] if not userop in sel_op]
    if 0 < len(wrongOps) and sel_op == ops_mc:
        for wOp in wrongOps:
            if ops_mc["-cliprange"] in wOp:
                wrongOps.remove(wOp)

    if 0 < len(wrongOps):
        print("input invalid option! :", wrongOps)
        print("valid options :", sel_op.values())
        exit()
    act_func()

else:
    print("not exist dir!!")
