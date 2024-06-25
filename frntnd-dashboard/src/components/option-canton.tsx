import React, { useState, useEffect } from 'react';

interface IOption {
    value: string;
    label: string;
}

interface SelectCantonComponentProps {
    provinciaId: string | undefined;
    onCantonChange?: (value: string) => void;
}

const SelectCantonComponent: React.FC<SelectCantonComponentProps> = ({ provinciaId, onCantonChange }) => {

    const [opciones, setOpciones] = useState<IOption[]>([]);

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                if (provinciaId) {
                    const response = await fetch(`http://localhost:8080/dpa/cantones/${provinciaId}`);
                    const data: { name: string; code: string }[] = await response.json();
                    const options: IOption[] = data.map((item) => ({
                        value: item.code,
                        label: item.name,
                    }));
                    setOpciones(options);
                }
            } catch (error) {
                console.error('Error al obtener los datos:', error);
            }
        };

        fetchOptions();
    }, [provinciaId]);

    return (
        <select onChange={(e) => onCantonChange?.(e.target.value)}>
            <option defaultValue="">Cantón</option>
            {opciones.map((opcion) => (
                <option key={opcion.value} value={opcion.value}>{opcion.label}</option>
            ))}
        </select>
    );
};

export default SelectCantonComponent;