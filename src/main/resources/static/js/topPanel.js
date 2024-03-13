const showNavbarInfo = (user) => {
    document.getElementById("top-panel").innerHTML =
        `<h5>${user.email} with roles: ${user.rolesToString}</h5>`
}
fetch('api/user/')
    .then(response => response.json())
    .then(data => showNavbarInfo(data))
    .catch(error => console.log(error))