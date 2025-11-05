package b.i.e;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Map;

/* compiled from: Reader.java */
/* loaded from: classes3.dex */
public interface i {
    Result a(c cVar, Map<d, ?> map) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
