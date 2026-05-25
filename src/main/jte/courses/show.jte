@import org.example.hexlet.dto.courses.CoursePage
@param CoursePage page

<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <title>${page.getCourse().getName()}</title>
</head>
<body>
    <main>
        <h1>${page.getCourse().getName()}</h1>
        <p>${page.getCourse().getDescription()}</p>
        <a href="/courses">← Назад к списку курсов</a>
    </main>
</body>
</html>
