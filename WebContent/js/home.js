const buttonGoToHomePage = document.getElementById('buttonGoToHomePage');
const buttonGoToMyConfereces = document.getElementById('buttonGoToMyConfereces');
buttonGoToHomePage.classList.remove('d-none');
buttonGoToMyConfereces.classList.add('d-none');

const isChecked = (checkboxes) => {
    let isChecked = false;
    for (i = 0; i < checkboxes.length; i++) {
        isChecked = checkboxes[i].checked;
        if (isChecked) {
            break;
        }
    }
    return isChecked;
};

const actions = document.getElementById('actions');
const checkboxes = document.getElementsByName('ids');

checkboxes.forEach((checkbox) => {
    checkbox.addEventListener('change', () => {
        if (isChecked(checkboxes)) {
            actions.classList.remove('d-none');
        } else {
            if (!actions.classList.contains('d-none')) {
                actions.classList.add('d-none');
            }
        }
    });
});
