import React, { Component } from 'react'

export default class Button extends Component {
    
message = () => alert("PASAME UNA FUNCION!")

    render() {
        return (
            <button onClick={typeof this.props.fn === "function" ? this.props.fn  : this.message} className="glow-on-hover">{this.props.palabra}</button>
        )
    }
}
