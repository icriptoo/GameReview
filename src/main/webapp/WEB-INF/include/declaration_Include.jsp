
<style>
.dropbtn {
    display: inline-block;
    color: black;
    text-align: center;
    padding: 8px 16px;
    text-decoration: none;
}

.dropdown:hover .dropbtn {
    background-color: red;
}

.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 100px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.show {display:block;}
</style>

<script>

function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    for (var d = 0; d < dropdowns.length; d++) {
      var openDropdown = dropdowns[d];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}

function showPopup(ue_id){
  var ue_id = ue_id;
  newWindow = window.open("/declarationWrite?b_idx=${boardVo.b_idx}&us_id=${ sessionScope.login.u_id }&ue_id=$" + ue_id + "","팝업창","width=500, height=600, top=10, left=10");
}

</script>