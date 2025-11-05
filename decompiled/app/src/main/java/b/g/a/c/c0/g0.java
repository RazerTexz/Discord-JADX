package b.g.a.c.c0;

import b.g.a.a.e;
import b.g.a.c.c0.g0;
import java.io.Serializable;

/* compiled from: VisibilityChecker.java */
/* loaded from: classes3.dex */
public interface g0<T extends g0<T>> {

    /* compiled from: VisibilityChecker.java */
    public static class a implements g0<a>, Serializable {
        public static final a j;
        private static final long serialVersionUID = 1;
        public final e.a _creatorMinLevel;
        public final e.a _fieldMinLevel;
        public final e.a _getterMinLevel;
        public final e.a _isGetterMinLevel;
        public final e.a _setterMinLevel;

        static {
            e.a aVar = e.a.PUBLIC_ONLY;
            e.a aVar2 = e.a.ANY;
            j = new a(aVar, aVar, aVar2, aVar2, aVar);
        }

        public a(e.a aVar, e.a aVar2, e.a aVar3, e.a aVar4, e.a aVar5) {
            this._getterMinLevel = aVar;
            this._isGetterMinLevel = aVar2;
            this._setterMinLevel = aVar3;
            this._creatorMinLevel = aVar4;
            this._fieldMinLevel = aVar5;
        }

        public final e.a a(e.a aVar, e.a aVar2) {
            return aVar2 == e.a.DEFAULT ? aVar : aVar2;
        }

        public a b(e.a aVar, e.a aVar2, e.a aVar3, e.a aVar4, e.a aVar5) {
            return (aVar == this._getterMinLevel && aVar2 == this._isGetterMinLevel && aVar3 == this._setterMinLevel && aVar4 == this._creatorMinLevel && aVar5 == this._fieldMinLevel) ? this : new a(aVar, aVar2, aVar3, aVar4, aVar5);
        }

        public String toString() {
            return String.format("[Visibility: getter=%s,isGetter=%s,setter=%s,creator=%s,field=%s]", this._getterMinLevel, this._isGetterMinLevel, this._setterMinLevel, this._creatorMinLevel, this._fieldMinLevel);
        }
    }
}
