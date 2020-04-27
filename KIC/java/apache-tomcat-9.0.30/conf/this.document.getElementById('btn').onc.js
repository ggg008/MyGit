var data = request.responseXML;
var names = data.getElementsByTagName('name');
var publishers = data.getElementsByTagName('publisher');

//console.log(names);
//console.log(names.length);
//console.log(names[0].childNodes[0].nodeValue);

for(var i = 0; i < names.length; ++i){
	console.log(names[i].childNodes[0].nodeValue);
	console.log(publishers[i].childNodes[0].nodeValue);
}

console.log('---------------');
names.forEach()
names.forEach(function(elt, i, array) {
	console.log('loop' + ' ' + elt + ' ' + i + ' ' + array);
})

Array.from()