<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="layout" content="main" />
    <asset:stylesheet src="timeCheckerForm.css" />
    <title>Formulaire</title>
  </head>

  <body>
    <h1>Gestionnaire de temps de travail</h1>

    <div class="g-form">
      <form class="time-form" action="${createLink(controller: 'timeManager', action: 'submit')}" method="POST">
        <div class="form-group">
          <label for="date">Date</label>
          <input type="date" name="date" class="form-control" value="${today}" />
        </div>
        <div class="form-group">
          <label for="heureArriveeMatin">Heure d'Arrivée le Matin</label>
          <input type="time" name="heureArriveeMatin" class="form-control" />
        </div>
        <div class="form-group">
          <label for="heureDepartMatin">Heure de Départ le Matin</label>
          <input type="time" name="heureDepartMatin" class="form-control" />
        </div>
        <div class="form-group">
          <label for="heureArriveeApresMidi"
            >Heure d'Arrivée l'Après-midi</label
          >
          <input
            type="time"
            name="heureArriveeApresMidi"
            class="form-control"
          />
        </div>
        <div class="form-group">
          <label for="heureDepartApresMidi">Heure de Départ l'Après-midi</label>
          <input type="time" name="heureDepartApresMidi" class="form-control" />
        </div>
        <button type="submit" class="btn btn-primary">Soumettre</button>
      </form>
    </div>
  </body>
</html>
