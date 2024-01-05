const gid = (id) => document.getElementById(id);

function st(key, value) {
  localStorage.setItem(key, JSON.stringify(value));
}

function ld(key) {
  return JSON.parse(localStorage.getItem(key));
}

function register() {
  const un = gid("username").value;
  const ps = gid("password").value;

  if (ld("username") === null) {
    // create new user
    st("username", un);
    st("password", ps);
    alert("User created");
    window.location.href = "login.html";
  } else {
    // user already exists
    alert(`User ${ld("username")} exists, can't create new user.`);
  }
}

function login() {
  const un = gid("loginUsername").value;
  const ps = gid("loginPassword").value;

  // check creds
  if (ld("username") === un && ld("password") === ps) {
    // correct creds
    alert("Login successful!");
    window.location.href = "profile.html";
  } else {
    // wrong creds
    alert("Invalid username or password.");
  }
}

function displayProfile() {
  gid("profileMessage").innerHTML = `Welcome to your profile, ${ld(
    "username"
  )}`;
}

function processPayment() {
  const creditCard = gid("creditCard").value;
  alert(`Payment processed successfully with credit card: ${creditCard}`);
}
