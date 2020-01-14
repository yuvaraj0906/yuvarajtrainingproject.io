
function validateMenuItemForm()
{
var title=document.forms["menuItemForm"]["title"].value;
if(title=="")
{
    alert("name is required");
    return false;
}
var titlelength=title.length;
if(titlelength < 2||titlelength >65)
{
    alert("name should have 2 to 65 characters");
    return false;
}
var price=document.forms["menuItemForm"]["price"].value;
if(isNaN(price)){
    alert("price has to be a number");
    return false;
}
if(price=="")
{
    alert("price is required");
    return false;
}
var dateOfLaunch=document.forms["menuItemForm"]["dateOfLaunch"].value;
if(dateOfLaunch==""){
alert("date of launch is required");
return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
  alert("Incorrect date format");
  return false;
}
var category=document.forms["menuItemForm"]["category"].value;
if(category=="0")
{
    alert("select any course");
    return false;
}
}
