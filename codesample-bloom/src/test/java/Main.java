import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static class Resource {
        int num, space;

        Resource(int num, int space) {
            this.num = num;
            this.space = space;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int loop = 0;

        List<Resource> resources = new ArrayList<Resource>();
        List<Integer> applySpace = new ArrayList<Integer>();

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strings = line.split(",");
            if (loop == 0)
                for (String string : strings) {
                    String[] segment = string.split(":");
                    resources.add(new Resource(Integer.parseInt(segment[0]), Integer.parseInt(segment[1])));
                }
            else if (loop == 1)
                for (String string : strings) applySpace.add(Integer.parseInt(string));
            if (++loop == 2) break;
        }

        String result = applySpace.stream()
                .map(req -> {
                            List<Resource> matchResources = resources.stream().filter(t -> t.space >= req && t.num > 0).collect(Collectors.toList());
                            if (matchResources.isEmpty()) return false;
                            Resource resource = matchResources.stream().min(Comparator.comparingInt(o -> o.space)).orElse(null);
                            --resource.num;
                            return true;
                        }
                )
                .map(Object::toString)
                .collect(Collectors.joining(","));

        System.out.println(result);
    }
}
