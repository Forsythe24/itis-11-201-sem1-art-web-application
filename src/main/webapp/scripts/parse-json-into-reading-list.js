function parseJsonIntoReadingList(strData){
    let listGroup = document.getElementById('list')
    listGroup.innerHTML = ''

    const jsonData = JSON.parse(strData)

    for(let i = 0; i < jsonData.length; i++) {
        let a = document.createElement('a')
        a.className = "list-group-item list-group-item-action flex-column"
        a.href = "/publication?publ_id=" + jsonData[i].publId

        let img = document.createElement('img')
        img.src = jsonData[i].image
        img.style.height = '180px'
        img.style.width = '280px'

        let spanTitleAuthor = document.createElement('span')
        spanTitleAuthor.className = 'mb-1'
        spanTitleAuthor.innerText = '"' + jsonData[i].title + '"' + " " + jsonData[i].author
        spanTitleAuthor.style.fontSize = '25px'
        spanTitleAuthor.style.marginLeft = '1.0rem'

        let spanGenre = document.createElement('span')
        spanGenre.className = 'text-muted text-end'
        spanGenre.style.marginLeft = '1.0rem'
        spanGenre.style.fontStyle = 'italic'
        spanGenre.innerText = jsonData[i].genre

        spanTitleAuthor.appendChild(spanGenre)

        a.appendChild(img)
        a.appendChild(spanTitleAuthor)

        listGroup.appendChild(a)
    }
}