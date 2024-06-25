import React, { useState, useEffect } from 'react';

interface IOption {
    value: string;
    label: string;
}

interface SelectCantonComponentProps {
    valueToSend: string | undefined;
}

const SelectCantonComponent: React.FC<SelectCantonComponentProps> = ({ valueToSend }) => {

    const [opciones, setOpciones] = useState<IOption[]>([]);

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                if (!valueToSend) {
                    return;
                }
                const response = await fetch(`http://localhost:8080/dpa/cantones/${valueToSend}`);
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
    }, [valueToSend]);

    return (
        <select>
            <option selected>Cantón</option>
            {opciones.map((opcion) => (
                <option key={opcion.value} value={opcion.value}>{opcion.label}</option>
            ))}
        </select>
    );
};

export default SelectCantonComponent;