package com.salsge.demo;

import com.salsge.demo.Employees.EmployeeController;

public enum ConsoleOption {

    LISTAR_TODOS(1) {
        @Override
        public boolean execute() {
            EmployeeController.getAllEmployees();
            return false;
        }
    },
    LISTAR(2) {
        @Override
        public boolean execute() {
            EmployeeController.getEmployee();
            return false;
        }
    },
    CREAR(3) {
        @Override
        public boolean execute() {
            EmployeeController.createEmployee();
            return false;
        }
    },
    EDITAR(4) {
        @Override
        public boolean execute() {
            EmployeeController.updateEmployee();
            return false;
        }
    },
    ELIMINAR(5) {
        @Override
        public boolean execute() {
            EmployeeController.deleteEmployee();
            return false;
        }
    },
    SALIR(6) {
        @Override
        public boolean execute() {
            return true;
        }
    };

    private final int opcion;

    ConsoleOption(int opcion) {
        this.opcion = opcion;
    }

    public abstract boolean execute();

    public static ConsoleOption convertEnum(int opcionUsuario) {
        for(ConsoleOption consoleOption : ConsoleOption.values()) {
            if(opcionUsuario == consoleOption.opcion) {
                return consoleOption;
            }
        }

        throw new IllegalArgumentException("No existe esa opcion");
    }

}
