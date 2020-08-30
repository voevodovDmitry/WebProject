const buttonGoToHomePage = document.getElementById('buttonGoToHomePage');
const buttonGoToMyConfereces = document.getElementById('buttonGoToMyConfereces');
buttonGoToHomePage.classList.add('d-none');
buttonGoToMyConfereces.classList.remove('d-none');
const checkboxes = document.querySelectorAll("input[name*='ids']");
checkboxes.forEach((elem) => elem.parentElement.classList.add('d-none'));
