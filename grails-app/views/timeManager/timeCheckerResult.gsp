<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="layout" content="main" />
    <title>Résultat-heure</title>
  </head>

  <body>
    <h1 class="modal-title title--page title--bold">Résultat de la saisie</h1>

    <table>
      <thead>
        <tr>
          <th>Date</th>
          <th>Total heures matin</th>
          <th>Total heures après-midi</th>
          <th>Total heures journée</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${params.date}</td>
          <td>${totalMatin}</td>
          <td>${totalApresMidi}</td>
          <td>${totalJour}</td>
        </tr>
        <g:each in="${times}" var="time">
          <tr>
            <td>${time.date}</td>
            <td>${time.totalMatin}</td>
            <td>${time.totalApresMidi}</td>
            <td>${time.totalJour}</td>
          </tr>
        </g:each>
      </tbody>
    </table>
    <g:link
      controller="timeManager"
      action="timeManagerForm"
      class="btn btn-primary"
      style="
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 10px auto;
        width: 100px;
        text-decoration: none;
      "
    >
      Ajouter
    </g:link>
  </body>
</html>
