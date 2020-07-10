<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<style type="text/css">
	
	.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
}

.button1 {
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
}

.button2:hover {
    box-shadow: 0 12px 16px 0 rgba(2, 202, 255, 0.24), 0 17px 50px 0 rgba(2, 202, 255, .24);
}
	
	</style>
	
	 
	 <style>
/* Popup container - can be anything you want */
.popup {
    position: relative;
    display: inline-block;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* The actual popup */
.popup .popuptext {
    visibility: hidden;
    width: 160px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 8px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
    visibility: visible;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
    from {opacity: 0;} 
    to {opacity: 1;}
}

@keyframes fadeIn {
    from {opacity: 0;}
    to {opacity:1 ;}
}
</style>
	 
</head>
<body>
twooooooooooooooooooo

	 	<br />
											<br />	////////////////////////////////////////////////
											<br />	
									<br />	
	<p><b>Note:</b> Internet Explorer does not support the resize property.</p>

<div style=" border: 2px solid;
    padding: 20px; 
    width: 300px;
    resize: both;
    overflow: auto;" >Let the user resize both the height and the width of this div element.</div> 
											
									<br />	////////////////////////////////////////////////	
									<br />	
									<br />				
										  <script type="text/javascript" src="myJS/jquery.min.js"></script>											
																
	 <script src="myJS/jquery.textext.min.js"></script>		
<textarea id="textarea" rows="1"></textarea>

<script type="text/javascript">
    $('#textarea')
        .textext({
        	  plugins : 'tags prompt focus autocomplete arrow ',
              tagsItems : [ 'Basic', 'JavaScript', 'PHP', 'Scala' ],
              prompt : 'Add one...'})
        .bind('getSuggestions', function(e, data)
        {
            var list = [
                    'Basic',
                    'Closure',
                    'Cobol',
                    'Delphi',
                    'Erlang',
                    'Fortran',
                    'Go',
                    'Groovy',
                    'Haskel',
                    'Java',
                    'JavaScript',
                    'OCAML',
                    'PHP',
                    'Perl',
                    'Python',
                    'Ruby',
                    'Scala'
                ],
                textext = $(e.target).textext()[0],
                query = (data ? data.query : '') || ''
                ;

            $(this).trigger(
                'setSuggestions',
                { result : textext.itemManager().filter(list, query) }
            );
        })
        ;
</script> 
<br />
											<br />	////////////////////////////////////////////////
											<br />	
									<br />
 <button class="button button2">Sh on Hover</button>
<br />
											<br />	////////////////////////////////////////////////
											<br />	
									<br />
 <div class="form-group">
                               	               
									<ul class="lab-no">
 
											<li class="style-li" ><strong >Select known Subjects:</strong></li>
											
											<li ></li>	
										</ul><div class="popup" > <span class="popuptext" id="myPopup">ctrl+click to select multiple subjects</span>
                                                 <select name="subs1" id="subs1" onfocus="myFunction()" multiple>
													
 															 <option value="">aaa</option>
 															 <option value="">bbb</option>
 															 <option value="">ccc</option>
 														

												</select>
												</div>
									</div>





</body>

<script>
// When the user clicks on div, open the popup
function myFunction() {
    var popup = document.getElementById("myPopup");
    popup.classList.toggle("show");
    
    window.setTimeout(function() {
    	  popup.classList.toggle("show");}, 5000);
  
  //  popup.classList.toggle("show");
}
</script>
</html>