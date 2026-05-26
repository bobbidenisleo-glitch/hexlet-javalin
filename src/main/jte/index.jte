@import org.example.hexlet.dto.MainPage
@param MainPage page

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Hello Hexlet!</title>
</head>
<body>
    <main>
        <h1>Привет, Хекслет!</h1>
        @if(!page.isVisited())
            <div style="background-color: #e8f4f8; border: 1px solid #bce8f1; padding: 15px; margin: 20px 0; border-radius: 5px;">
                Это сообщение показывается только один раз. 
                Если вы хотите увидеть его снова, сотрите куки в панели разработчика.
            </div>
        @endif
        
        <div>
            <p>Куки "visited": ${page.isVisited() ? "установлена (вы уже посещали сайт)" : "не установлена (первое посещение)"}</p>
        </div>
        
        <div style="margin-top: 20px;">
            <a href="/">Обновить страницу</a>
        </div>
    </main>
</body>
</html>
