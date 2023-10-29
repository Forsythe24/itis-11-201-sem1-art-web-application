
function turnJsonIntoQuotes(strData){
    const jsonData = JSON.parse(strData)
    let listGroup = document.getElementById('list')
    listGroup.innerHTML = ''
    for(let i = jsonData.length - 1; i >= 0; i--) {
        let a = document.createElement('a')
        a.className = "list-group-item list-group-item-action flex-column"

        let pText = document.createElement('p')
        pText.className = 'mb-1'
        pText.style.fontSize = "25px"
        pText.style.fontFamily = "Times New Roman"
        pText.innerText = "— " + jsonData[i].text

        let pAuthor = document.createElement('p')
        pAuthor.className = 'text-muted text-end'
        pAuthor.innerText = jsonData[i].author
        pAuthor.style.fontStyle = "italic"

        a.appendChild(pText)
        a.appendChild(pAuthor)

        listGroup.appendChild(a)
    }
}