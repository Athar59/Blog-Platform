// header section
const hamburger = document.getElementById('hamburger');
const navLinks = document.getElementById('nav-links');
hamburger.addEventListener('click', () => {
  navLinks.classList.toggle('active');
});

window.addEventListener('click', (e) => {
  if (!navLinks.contains(e.target) && !hamburger.contains(e.target)) {
    navLinks.classList.remove('active');
    mobileProfile.classList.remove('active');
  }
});

const mobileProfileToggle = document.getElementById('mobile-profile-toggle');
const mobileProfile = document.getElementById('mobile-profile');
mobileProfileToggle.addEventListener('click', () => {
  mobileProfile.classList.toggle('active');
});

const desktopProfileToggle = document.getElementById('desktop-profile-toggle');
const desktopProfile = document.getElementById('desktop-profile');
desktopProfileToggle.addEventListener('click', () => {
  desktopProfile.classList.toggle('active');
});

window.addEventListener('click', (e) => {
  if (!desktopProfile.contains(e.target) && !desktopProfileToggle.contains(e.target)) {
    desktopProfile.classList.remove('active');
  }
});

document.addEventListener("DOMContentLoaded", function () {
    const searchInput = document.getElementById('searchInput');
    if (searchInput) {
        console.log("searchInput event attached");
        searchInput.addEventListener('input', function () {
            const searchValue = this.value.toLowerCase();
            const cards = document.querySelectorAll('.card');

            cards.forEach(card => {
                const title = card.querySelector('h3').textContent.toLowerCase();
                card.style.display = title.includes(searchValue) ? 'block' : 'none';
            });
        });
    } else {
        console.warn("🔍 searchInput not found");
    }
});

// smooth scrolling
window.onload = function () {
   const id = window.location.hash;
   if (id) {
     const section = document.querySelector(id);
     if (section) {
       section.scrollIntoView({ behavior: "smooth" });
     }
   }
 };
