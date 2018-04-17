var stompClient = null;
var socket = null;;

$(document).ready(function () {
    socket = new SockJS('http://192.168.0.158:8080/stopm-endpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}/*headers*/,/*callback*/ function (frame) {
        $( "#incoming-messages" ).html("Bienvenido al chat de Pixart    ");
        stompClient.subscribe('/topic/messages', function (message) {
            var msg = JSON.parse(message.body);
            $( "#incoming-messages" ).append("<br>"+msg.from+": "+msg.text);
        });
    });
    $( "#send-button" ).click(function() { sendMessage($( "#text-input" ).val()) });
});

function sendMessage(message) {
    stompClient.send("/app/messages", {}, JSON.stringify({'from': $( "#username" ).val(),'text':message}));
}

