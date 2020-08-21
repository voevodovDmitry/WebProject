function sendMenuForm(section) {
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
	Console(childs);
	childs[0].value = '';
	childs[2].value = '';
	let deleteButton = getDeleteButton();
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

function addCollum(){
	
	
	
}










