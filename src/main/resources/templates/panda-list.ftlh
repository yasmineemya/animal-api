<!DOCTYPE html>
<html>
<head><title>Panda List</title></head>
<body>
<h1>All Pandas</h1>
<a href="/pandas/new-form">Create New Panda</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Type</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <#list pandaList as panda>
        <tr>
            <td>${panda.id}</td>
            <td>${panda.name}</td>
            <td>${panda.type}</td>
            <td>${panda.description}</td>
            <td>
                <a href="/pandas/${panda.id}">View</a> |
                <a href="/pandas/update-form/${panda.id}">Update</a> |
                <a href="/pandas/delete/${panda.id}">Delete</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>
