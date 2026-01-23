package lombok.patcher;

/* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/TransplantMapper.SCL.lombok */
public interface TransplantMapper {
    public static final TransplantMapper IDENTITY_MAPPER = new C129141();

    String mapResourceName(int i, String str);

    /* JADX INFO: renamed from: lombok.patcher.TransplantMapper$1 */
    /* JADX INFO: loaded from: discord-126021.apk:lombok/patcher/TransplantMapper$1.SCL.lombok */
    class C129141 implements TransplantMapper {
        C129141() {
        }

        @Override // lombok.patcher.TransplantMapper
        public String mapResourceName(int classFileFormatVersion, String resourceName) {
            return resourceName;
        }
    }
}
