 /* const uncheckOption = () => {
        var item = document.getElementsByClassName('border');
        item[0].classList.remove('border');
      };

      const  checkOption = (elem) => {
        uncheckOption();
        elem.classList.add('border');
      }

      const filter = document.getElementById('filter');
      filter.onclick = (e) => {
		console.log(e);
        if (e.target.parentElement.tagName === 'LI') {
          checkOption(e.target.parentElement);
        }
        if (e.target.tagName === 'LI') {
          checkOption(e.target);
        }
      };
*/

const setDefaultActiveTab = () => {
	const item = document.getElementsByClassName('border');
	if (!item[0]) {
		const firstTab = document.getElementById('firstTab');
		firstTab.classList.add('border');
	}
}

