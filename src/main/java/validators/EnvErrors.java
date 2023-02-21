package validators;

import static colors.Colors.RED;

public enum EnvErrors {
    NOTHAVEENVIRONMENT(RED + "��� ������� ��������� ���������� ��������� �� ���� ��������, " +
            " ��������� ��������� ������, ������� ���������� ���������" + RED),
    WRONGENVIRONMENT(RED + "��� ������� ��������� ���������� ��������� �� ����� �������� ��������, " +
            "���� ���� �������� �������� ���������� ��������� ��������� ��������� ������ � ��������� ���������� ���������" + RED),
    EMPTYENVIRONMENT(RED + "������ ���������� ��������� ����� ������ ��������, ������� ���������� ������������ ����� � ���������� � " +
            "��������� ��������� ������ � ��������� ���������� ���������" + RED),
    NOTHAVEERRORS(RED + "������ �� ���� �������" + RED);

    final String error;
    EnvErrors(String error){
        this.error = error;
    }

    @Override
    public String toString() {
        return error;
    }
}
