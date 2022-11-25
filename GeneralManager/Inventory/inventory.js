var survey_options = document.getElementById('branch');
var add_more_fields = document.getElementById('addBranches');
// var remove_fields = document.getElementById('remove_fields');

function addFields(){
  var newField = document.createElement('input');
  newField.setAttribute('type','text');
  newField.setAttribute('name','quantity[]');
  newField.setAttribute('placeholder','Quantity');
  survey_options.appendChild(newField);
  
  var newField1 = document.createElement('input');
  newField1.setAttribute('type','text');
  newField1.setAttribute('name','branchID[]');
  newField1.setAttribute('placeholder','Branch ID');

  var newField2 = document.createElement('input');
  newField2.setAttribute('type','text');
  newField2.setAttribute('name','handlingTime[]');
  newField2.setAttribute('placeholder','Handling Time in Days');
  
  
  survey_options.appendChild(newField1);
  survey_options.appendChild(newField2);
}

// remove_fields.onclick = function(){
//   var input_tags = survey_options.getElementsByTagName('input');
//   if(input_tags.length > 2) {
//     survey_options.removeChild(input_tags[(input_tags.length) - 1]);
//   }
// }