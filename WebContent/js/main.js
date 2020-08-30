function sendMenuForm(section) {
	console.log('sendMenuForm');
	let form = document.getElementById('menuForm');
	form.section.value = section;
	form.submit();
}

function sendOperationForm(operation) {
	let form = document.getElementById('operationForm');
	form.operation.value = operation;
	form.submit();
}

function addEvent() {
	let event = document.getElementById('event');
	let newEvent = event.cloneNode(true);
	newEvent.id = '';
	let childs = newEvent.children;
	childs[0].value = '';
	childs[1].value = '';
	childs[0].classList.add('mt-5');
	let deleteButton = getDeleteButton();
	deleteButton.classList.add('btn', 'btn-danger', 'mt-4');
	newEvent.append(deleteButton);
	newConfForm.append(newEvent);
}

function getDeleteButton() {
	let input = document.createElement('input');
	input.type = 'button';
	input.value = 'Delete event';
	input.onclick = deleteEvent;
	return input;
}

function deleteEvent(button) {
	let event = button.target.parentElement;
	event.remove();
}
