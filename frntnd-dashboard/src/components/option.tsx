import React, { useState, useEffect } from 'react';

interface IOption {
    value: string;
    label: string;
}

const SelectComponent: React.FC = () => {

    const [opciones, setOpciones] = useState<IOption[]>([]);

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                const response = await fetch('http://localhost:8080/dpa/provincias');
                const data: { name: string; code: string }[] = await response.json();
                const options: IOption[] = data.map((item) => ({
                    value: item.code,
                    label: item.name,
                }));
                setOpciones(options);
            } catch (error) {
                console.error('Error al obtener los datos:', error);
            }
        };

        fetchOptions();
    }, []);

    return (
        <select>
            <option selected>Provincia</option>
            {opciones.map((opcion) => (
                <option key={opcion.value} value={opcion.value}>{opcion.label}</option>
            ))}
        </select>
    );
};

export default SelectComponent;