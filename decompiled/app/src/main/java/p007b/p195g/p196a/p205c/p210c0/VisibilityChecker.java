package p007b.p195g.p196a.p205c.p210c0;

import java.io.Serializable;
import p007b.p195g.p196a.p197a.JsonAutoDetect;
import p007b.p195g.p196a.p205c.p210c0.VisibilityChecker;

/* JADX INFO: renamed from: b.g.a.c.c0.g0, reason: use source file name */
/* JADX INFO: compiled from: VisibilityChecker.java */
/* JADX INFO: loaded from: classes3.dex */
public interface VisibilityChecker<T extends VisibilityChecker<T>> {

    /* JADX INFO: renamed from: b.g.a.c.c0.g0$a */
    /* JADX INFO: compiled from: VisibilityChecker.java */
    public static class a implements VisibilityChecker<a>, Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4709j;
        private static final long serialVersionUID = 1;
        public final JsonAutoDetect.a _creatorMinLevel;
        public final JsonAutoDetect.a _fieldMinLevel;
        public final JsonAutoDetect.a _getterMinLevel;
        public final JsonAutoDetect.a _isGetterMinLevel;
        public final JsonAutoDetect.a _setterMinLevel;

        static {
            JsonAutoDetect.a aVar = JsonAutoDetect.a.PUBLIC_ONLY;
            JsonAutoDetect.a aVar2 = JsonAutoDetect.a.ANY;
            f4709j = new a(aVar, aVar, aVar2, aVar2, aVar);
        }

        public a(JsonAutoDetect.a aVar, JsonAutoDetect.a aVar2, JsonAutoDetect.a aVar3, JsonAutoDetect.a aVar4, JsonAutoDetect.a aVar5) {
            this._getterMinLevel = aVar;
            this._isGetterMinLevel = aVar2;
            this._setterMinLevel = aVar3;
            this._creatorMinLevel = aVar4;
            this._fieldMinLevel = aVar5;
        }

        /* JADX INFO: renamed from: a */
        public final JsonAutoDetect.a m1898a(JsonAutoDetect.a aVar, JsonAutoDetect.a aVar2) {
            return aVar2 == JsonAutoDetect.a.DEFAULT ? aVar : aVar2;
        }

        /* JADX INFO: renamed from: b */
        public a m1899b(JsonAutoDetect.a aVar, JsonAutoDetect.a aVar2, JsonAutoDetect.a aVar3, JsonAutoDetect.a aVar4, JsonAutoDetect.a aVar5) {
            return (aVar == this._getterMinLevel && aVar2 == this._isGetterMinLevel && aVar3 == this._setterMinLevel && aVar4 == this._creatorMinLevel && aVar5 == this._fieldMinLevel) ? this : new a(aVar, aVar2, aVar3, aVar4, aVar5);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }
    }
}
