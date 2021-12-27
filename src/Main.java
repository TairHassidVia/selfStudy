import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<Integer>> edgeIdToPatchIds = new HashMap<>();
        for (int i = 0 ; i < 10 ; i++) {
            edgeIdToPatchIds.put(i, new ArrayList<>());
        }

        int j = 0;
        for(; j < edgeIdToPatchIds.size() ; j++) {
            for(int k = 0 ; k < 4 ; k++) {
                edgeIdToPatchIds.get(j).add(k);
            }
        }
    }

    public boolean writeArtifact(Map<Integer, List<Integer>> edgeIdToPatchIds) {
        Schema schema = new Schema.Parser().parse(SCHEMA_RESOURCE_NAME);
        File edgeFile = new File(fileName);
        edgeFile.getParentFile().mkdirs();

        List<GenericRecord> patchIds = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : edgeIdToPatchIds.entrySet()) {
            GenericRecord m = new GenericData.Record(schema);
            m.put("edge_id", entry.getKey());
            m.put("patch_ids", entry.getValue());
        }


        return false;
    }

}
