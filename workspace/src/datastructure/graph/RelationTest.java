/**
 * 회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은 특정 프로젝트가
 * 완료되어야하만 진행할 수 있는 프로젝트가 있다.
 * 프로젝트의 목록과 각 프로젝트간 의존여부를 넘겨주면
 * 의존도에 입각한 프로젝트의 진행순서를 반환하는 함수를 구현하시오.
 *
 * ex)
 * projects: a, b, c, d, e, f, g
 * dependencies: (f, a), (f, b), (f, c), (b, a),
 *               (c, a), (a, e), (b, e), (d, g)
 * f -> b -> c -> a -> d -> e -> g
 */

package datastructure.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Project {
    private String name;
    private LinkedList<Project> dependencies;
    private boolean marked;

    public Project(String name) {
        this.name = name;
        this.marked = false;
        this.dependencies = new LinkedList<>();
    }

    public void addDependency(Project before) {
        if (!dependencies.contains(before)) {
            dependencies.add(before);
        }
    }

    public LinkedList<Project> getDependencies() {
        return dependencies;
    }

    public String getName() {
        return name;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}

class ProjectManager {
    private HashMap<String, Project> projects;

    public ProjectManager(String[] names, String[][] dependencies) {
        projects = new HashMap<>();
        buildProjects(names);
        addDependencies(dependencies);
    }

    private void buildProjects(String[] names) {
        Arrays.stream(names)
                .forEach(name -> projects.put(name, new Project(name)));
    }

    private void addDependencies(String[][] dependencies) {
        for (String[] dependency : dependencies) {
            Project before = findProject(dependency[0]);
            Project after = findProject(dependency[1]);
            after.addDependency(before);
        }
    }

    private Project findProject(String name) {
        return projects.get(name);
    }

    private int index;

    public Project[] buildOrder() {
        Project[] ordered = new Project[projects.size()];
        index = 0;
        for (Project project : projects.values()) {
            buildOrder(project, ordered);
        }

        return ordered;
    }

    private void buildOrder(Project project, Project[] ordered) {
        if (!project.getDependencies().isEmpty()) {
            for (Project dependency : project.getDependencies()) {
                buildOrder(dependency, ordered);
            }
        }

        if (!project.isMarked()) {
            project.setMarked(true);
            ordered[index++] = project;
        }
    }
}

public class RelationTest {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
        String[][] dependencies = {{"f", "a"}, {"f", "b"}, {"f", "c"}, {"b", "a"},
                {"c", "a"}, {"a", "e"}, {"b", "e"}, {"d", "g"}};
        ProjectManager pm = new ProjectManager(projects, dependencies);
        Project[] order = pm.buildOrder();
        Arrays.stream(order)
                .forEach(p -> System.out.print(p.getName() + " "));
    }
}
