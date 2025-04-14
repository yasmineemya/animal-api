<!DOCTYPE html>
<html>
<head><title>Update Panda</title></head>
<body>
<h1>Update Panda</h1>
<form action="/pandas/update" method="post">
    <input type="hidden" name="id" value="${panda.id}">
    Name: <input type="text" name="name" value="${panda.name}"><br>
    Type: <input type="text" name="type" value="${panda.type}"><br>
    Description: <input type="text" name="description" value="${panda.description}"><br>
    <button type="submit">Update</button>
</form>
<a href="/pandas/all">Back to List</a>
</body>
</html>
