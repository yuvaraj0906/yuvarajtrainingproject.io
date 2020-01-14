function validateForm()
{
var title=document.forms["editMovieItem"]["name"].value;
if(title=="")
{
    alert("Title is required");
    return false;
}
var titlelength=title.length;
if(titlelength < 2||titlelength >65)
{
    alert("Name should have 2 to 65 characters");
    return false;
}
var gross=document.forms["editMovieItem"]["price"].value;
if(isNaN(gross)){
    alert("Gross has to be a number");
    return false;
}
if(gross=="")
{
    alert("Gross is required");
    return false;
}
var dateOfLaunch=document.forms["editMovieItem"]["dateOfLaunch"].value;
if(dateOfLaunch==""){
alert("Date of launch is required");
return false;
}
if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\-\/.](?:(0[1-9]|1[012])[\-\/.](19|20)[0-9]{2})$/)){
  alert("Incorrect date format. Expected format(dd/mm/yyyy)");
  return false;
}
var genre=document.forms["editMovieItem"]["genre"].value;
  if(genre=="0")
  {
      alert("Select any Genre");
      return false;
}
}