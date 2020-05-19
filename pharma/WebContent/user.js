var part1 = document.getElementById("info");
var part2 = document.getElementById("pharmainfo");
var part3 = document.getElementById("medicneinfo");
var part4 = document.getElementById("request");
var part5 = document.getElementById("allrequest");
document.getElementById("bnt1").addEventListener("click",function()
    {  
         part1.style.display = "block";
         part2.style.display = "none";
         part3.style.display = "none";
         part4.style.display = "none";
         part5.style.display = "none";

                                                  
});
document.getElementById("bnt2").addEventListener("click",function()
    {                                               
    
   
     part2.style.display = "block";
     part1.style.display = "none";
     part3.style.display = "none";
     part4.style.display = "none";
     part5.style.display = "none";
  
                                                  
});
document.getElementById("bnt3").addEventListener("click",function()
    {  
    
   
    part3.style.display = "block";
     part1.style.display = "none";
     part2.style.display = "none";
     part4.style.display = "none";
     part5.style.display = "none";
  
                                                  
});
document.getElementById("bnt4").addEventListener("click",function()
    {                                               
    
     part1.style.display = "none";
     part2.style.display = "none";
     part3.style.display = "none";
    part4.style.display = "block";
    part5.style.display = "none";
 
                                                  
});
document.getElementById("bnt5").addEventListener("click",function()
	    {                                               
	    
	     part1.style.display = "none";
	     part2.style.display = "none";
	     part3.style.display = "none";
	    part4.style.display = "none";
	    part5.style.display = "block";
	 
	                                                  
	});
