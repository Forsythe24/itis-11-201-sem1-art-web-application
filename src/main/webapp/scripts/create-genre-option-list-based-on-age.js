const genreArr = ["Adventure Fiction", "Arts & New Media", "Biographies & Memoirs", "Children's Fiction",
"Classic Literature", "Classic Foreign Literature", "Contemporary", "Criticism", "Detective Fiction",
"Fantasy", "Health, Fitness & Dieting", "Historical Fiction", "History", "Humour & Entertainment",
"Love Story", "Modern Literature", "Nonfiction", "Plays", "Poetry", "Psychology", "Religion",
"Romance", "Science & Philosophy", "Science Fiction", "Self Help", "Short Stories",
"Spirituality", "Sports", "Travel", "Young Adult Fiction", "Crime", "Erotica", "Horror", "Mystery, Thriller & Suspense"]


function createOptionsWithRecentPublications(dateString) {
    genreArr.reverse()
    genreArr.push("Recent Publications")
    genreArr.reverse()
    createOptions(dateString)
}

function createOptionsForAuthorizedUser(dateString) {
    genreArr.reverse()
    genreArr.push("My Works")
    genreArr.push("Recent Publications")
    genreArr.reverse()
    createOptions(dateString)
}
function createOptions (dateString){
    select = document.getElementById("select-genre");
    removeOptions(select)
    var length = genreArr.length
    if (getAge(dateString) < 18 || dateString == null) {
        length -= 4
    }
    for (var i = 0; i < length; i++) {
        var opt = document.createElement('option')
        opt.text = genreArr[i]
        select.appendChild(opt);
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