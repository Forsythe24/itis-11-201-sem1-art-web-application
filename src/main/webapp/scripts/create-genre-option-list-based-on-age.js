const genrelist = ["Adventure Fiction", "Arts & New Media", "Biographies & Memoirs", "Children's Fiction",
"Classic Literature", "Classic Foreign Literature", "Contemporary", "Criticism", "Detective Fiction",
"Fantasy", "Health, Fitness & Dieting", "Historical Fiction", "History", "Humour & Entertainment",
"Love Story", "Modern Literature", "Nonfiction", "Plays", "Poetry", "Psychology", "Religion",
"Romance", "Science & Philosophy", "Science Fiction", "Self Help", "Short Stories",
"Spirituality", "Sports", "Travel", "Young Adult Fiction", "Crime", "Erotica", "Horror", "Mystery, Thriller & Suspense"]

createOptions()
function createOptions (){
    select = document.getElementById("select-genre");
    genre = select.value
    removeOptions(select)
    var length = genrelist.length
    date = document.getElementById("birth-date")
    if (getAge(date.value) < 18 || date == null) {
        length -= 4
    }
    for (var i = 0; i < length; i++) {
        var opt = document.createElement('option')
        opt.text = genrelist[i]
        select.appendChild(opt);
        if (genre == genrelist[i]) {
            opt.selected = true
        }
    }
    var other = document.createElement('option')
    other.text = "Other"
    select.appendChild(other)
}

function removeOptions(selectElement) {
    var i, L = selectElement.options.length - 1;
    for(i = L; i >= 0; i--) {
        selectElement.remove(i);
    }
}

function getAge(dateString) {
    var today = new Date();
    var birthDate = new Date(dateString);
    var age = today.getFullYear() - birthDate.getFullYear();
    var m = today.getMonth() - birthDate.getMonth();
    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }
    return age;
}