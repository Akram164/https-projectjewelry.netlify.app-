function orderNow() {
    alert("Thank you for your order! We will prepare your burger with love.");
}

document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();
    alert("Thank you for contacting us! We will get back to you soon.");
});