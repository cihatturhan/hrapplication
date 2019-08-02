'use strict';

var singleUploadForm = document.querySelector('#fileUploadButton');
var singleFileUploadInput = document.querySelector('#fileUploadInput');
var singleFileUploadError = document.querySelector('#UploadError');
var singleFileUploadSuccess = document.querySelector('#fileUploadSuccess');
var singleFileUploadWarning = document.querySelector('#fileUploadWarning');
var dBFileId = document.querySelector('#dBFileId');



function uploadSingleFile(file) {
    var formData = new FormData();
    formData.append("file", file);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/uploadFile");

    xhr.onload = function() {
        console.log(xhr.responseText);
        var response = JSON.parse(xhr.responseText);
        singleFileUploadWarning.innerHTML="";
        if(xhr.status == 200) {
        	console.log("done");
            singleFileUploadError.style.display = "none";
            singleFileUploadSuccess.innerHTML = "<p>File Uploaded Successfully.</p>";
            singleFileUploadSuccess.style.display = "block";
            dBFileId.value=response.fileId;
        } else {
            singleFileUploadSuccess.style.display = "none";
            singleFileUploadError.innerHTML = (response && response.message) || "Some Error Occurred";
        }
    }

    xhr.send(formData);
}



singleUploadForm.addEventListener('click', function(event){
    var files = singleFileUploadInput.files;
    singleFileUploadWarning.innerHTML="Please wait File is being uploaded";
    if(files.length === 0) {
        singleFileUploadError.innerHTML = "Please select a file";
        singleFileUploadError.style.display = "block";
    }
    uploadSingleFile(files[0]);
    event.preventDefault();
}, true);

