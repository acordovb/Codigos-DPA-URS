import React, { useState, useEffect } from 'react';

interface IOption {
    value: string;
    label: string;
}

interface SelectParroquiaComponentProps {
    provinciaId: string | undefined;
    cantonId: string | undefined;
    onParroquiaChange?: (value: string) => void;
}

const SelectParroquiaComponent: React.FC<SelectParroquiaComponentProps> = ({ provinciaId, cantonId, onParroquiaChange }) => {

    const [opciones, setOpciones] = useState<IOption[]>([]);

    useEffect(() => {
        const fetchOptions = async () => {
            try {
                if (provinciaId && cantonId) {
                    const response = await fetch(`http://localhost:8080/dpa/parroquias/${provinciaId}/${cantonId}`);
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
    }, [provinciaId, cantonId]);

    return (
        <select onChange={(e) => onParroquiaChange?.(e.target.value)}>
            <option defaultValue="">Parroquia</option>
            {opciones.map((opcion) => (
                <option key={opcion.value} value={opcion.value}>{opcion.label}</option>
            ))}
        </select>
    );
};

export default SelectParroquiaComponent;