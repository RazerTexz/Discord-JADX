package com.discord.utilities.view.validators;

import android.view.View;
import androidx.annotation.MainThread;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.p580t._Collections;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ValidationManager.kt */
/* loaded from: classes2.dex */
public final class ValidationManager {
    private final LinkedHashMap<String, Input<? extends View>> inputs;

    public ValidationManager() {
        this.inputs = new LinkedHashMap<>();
    }

    public static /* synthetic */ boolean validate$default(ValidationManager validationManager, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return validationManager.validate(z2);
    }

    @MainThread
    public final void addInput(Input<? extends View> input) {
        Intrinsics3.checkNotNullParameter(input, "input");
        this.inputs.put(input.getName(), input);
    }

    @MainThread
    public final void removeInput(String name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.inputs.remove(name);
    }

    @MainThread
    public final Collection<String> setErrors(Map<String, ? extends List<String>> errorMap) {
        Intrinsics3.checkNotNullParameter(errorMap, "errorMap");
        ArrayList arrayList = new ArrayList();
        Collection<Input<? extends View>> collectionValues = this.inputs.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "inputs.values");
        for (Input input : _Collections.reversed(collectionValues)) {
            List<String> list = errorMap.get(input.getName());
            if (input.setErrorMessage(list != null ? (String) _Collections.firstOrNull((List) list) : null)) {
                arrayList.add(input.getName());
            }
        }
        return _Sets.minus((Set) errorMap.keySet(), (Iterable) arrayList);
    }

    @MainThread
    public final boolean validate(boolean showErrors) {
        boolean z2;
        Collection<Input<? extends View>> collectionValues = this.inputs.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "inputs.values");
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            while (it.hasNext()) {
                z2 = ((Input) it.next()).validate(showErrors) && z2;
            }
            return z2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ValidationManager(Input<? extends View>... inputArr) {
        this();
        Intrinsics3.checkNotNullParameter(inputArr, "inputs");
        LinkedHashMap<String, Input<? extends View>> linkedHashMap = this.inputs;
        for (Input<? extends View> input : inputArr) {
            linkedHashMap.put(input.getName(), input);
        }
    }
}
