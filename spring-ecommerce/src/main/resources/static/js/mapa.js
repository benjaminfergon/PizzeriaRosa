window.onload = function() {

	// Variable para el mapa
	var mapa;

	mapa = new Microsoft.Maps.Map(
		'#mapa',
		{
			credentials: 'Ajaqw1Xy-OD-gQDXu5QJS8vtUxumIljCLLSdcQcp5EWAtVp9f6QsFd46vNzZP575',
			center: new Microsoft.Maps.Location(43.543194, -5.664313),
			mapTypeId: Microsoft.Maps.MapTypeId.street,
			zoom: 16
		});

	var center = mapa.getCenter();
	// Crear pushpin con la localización
	var pin = new Microsoft.Maps.Pushpin(center, {
		anchor: new Microsoft.Maps.Point(12, 39),
		title: "Pizzería Rosa",
		subTitle: "",
		color: "blue"
	});
	mapa.entities.push(pin);

}
