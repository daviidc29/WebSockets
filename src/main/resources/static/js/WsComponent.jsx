class WSClient extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            msg: ""
        };
    }

    componentDidMount() {
        // Crear la conexión WebSocket
        this.ws = new WebSocket(`ws://${globalThis.location.host}/timer`);

        // Escuchar mensajes
        this.ws.onmessage = (event) => {
            this.onMessage(event);
        };

        // Manejar errores
        this.ws.onerror = (event) => {
            this.onError(event);
        };
    }

    // Método que se llama cuando llega un mensaje del servidor
    onMessage(event) {
        console.log("In onMessage", event);
        this.setState({
            isLoaded: true,
            msg: event.data
        });
    }

    // Método que se llama cuando ocurre un error
    onError(event) {
        console.log("In onError", event);
        this.setState({
            error: event
        });
    }

    // Método render: define lo que se muestra en la pantalla
    render() {
        console.log("Rendering...");
        const { error, isLoaded, msg } = this.state;

        if (error) {
            return <div>Error: {error.message}</div>;
        } else if (!isLoaded) {
            return <div>Loading...</div>;
        } else {
            return (
                <div>
                    <h1>The server status is:</h1>
                    <p>{msg}</p>
                </div>
            );
        }
    }
}

// Montar el componente en el HTML
ReactDOM.render(
    <WSClient />,
    document.getElementById('timer')
);
