import os, sys, shutil, re
import subprocess as sub

# 참조경로 이미지소스경로

def simpleClipMover():              
    clip_path = sys.argv[1]
    clip_source_path = sys.argv[2]
    target_path = 'V:\\LF_Camera\\clip_convert_gt'

    frames = os.listdir(clip_path)
    clip_list = [s for s in os.listdir(clip_path) if "clip" in s]

    
    # searched = [s for s in sys.argv if "-cliprange" in s]#-cliprange_1_41

    print("start simpleClipMover!")
    
    print("clips")
    print(clip_list)

    
    if clip_path[-1] == os.sep:
        clip_path = clip_path[:-1]
    if clip_source_path[-1] == os.sep:
        clip_source_path = clip_source_path[:-1]

    for clip in clip_list:
        c_path = clip_path + os.sep + clip
        frames = os.listdir(c_path )
        print("frames")
        print(frames)
        
        for frame in frames:
            # f_path = c_path + os.sep + frame
            # print(f_path)
            
            source_path = clip_source_path + os.sep + frame.split('_')[-1]
            move_path_clip = target_path + os.sep + clip_path.split(os.sep)[-1] + os.sep + clip
            move_path_file = move_path_clip + os.sep + frame.split('_')[-1]
            
            ismove = True

            if not os.path.isdir(move_path_clip) :
                if "-automkdir" in sys.argv:
                    os.mkdir(move_path_clip)
                else:
                    print("없는 경로입니다. ", move_path_clip) 
                    ismove = False
            if ismove :
                print(source_path,"\n\t >>>>>MOVE!>>>>> ", move_path_file)                
                shutil.move(source_path, move_path_file)
    print("done!")

simpleClipMover()