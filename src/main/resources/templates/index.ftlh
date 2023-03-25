<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>info</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3>List of Movies:</h3>
    <table class="table table-warning table-group-divider">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Movie</th>
            <th scope="col">Author</th>
            <th scope="col">Year</th>
        </tr>
        </thead>
        <tbody class="table-group-divider">
        <#if movies??>
        <#list movies as movie>
            <tr>
                <td> ${movie.id!"-- не указано --"}</td>
                <td> ${movie.name!"-- не указано --"}</td>
                <td> ${movie.author!"-- не указано --"}</td>
                <td> ${movie.year!"-- не указано --"}</td>
            </tr>
        </#list>
        <#else>
            <p>No movies found.</p>
        </#if>
        </tbody>
    </table>

</div>
</body>
</html>