function validation()
{
var nm,pass;
nm=document.signup.fname.value;
num1=document.signup.fprice.value;
date=document.signup.date.value;


	if(nm=="")
	{
		alert("Title is required");
		
	}
       else if(nm.length<2 || nm.length>65)
	{
		alert("Title should have 2 to 65 characters");	
		
	
	}
        else if(num1=="")
	{
		alert("Price is required");
		
	}
       else if(isNaN(num1)){
	    alert("Price is not a number");
       
       }
        
	else if(date=="")
	{
		alert("date of launch is required");
		
	}
	
      
       else{
	alert("Form Submitted SuccessFully");
        //window.open("edit-movie-status.html");
	return true;
        }
     
	return false;
  
 
}
