package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* renamed from: androidx.work.impl.utils.LiveDataUtils$1 */
    public class C07751<In> implements Observer<In> {
        public Out mCurrentOutput = null;
        public final /* synthetic */ Object val$lock;
        public final /* synthetic */ Function val$mappingMethod;
        public final /* synthetic */ MediatorLiveData val$outputLiveData;
        public final /* synthetic */ TaskExecutor val$workTaskExecutor;

        /* renamed from: androidx.work.impl.utils.LiveDataUtils$1$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Object val$input;

            public AnonymousClass1(Object obj) {
                this.val$input = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (C07751.this.val$lock) {
                    ?? Apply = C07751.this.val$mappingMethod.apply(this.val$input);
                    C07751 c07751 = C07751.this;
                    Out out = c07751.mCurrentOutput;
                    if (out == 0 && Apply != 0) {
                        c07751.mCurrentOutput = Apply;
                        c07751.val$outputLiveData.postValue(Apply);
                    } else if (out != 0 && !out.equals(Apply)) {
                        C07751 c077512 = C07751.this;
                        c077512.mCurrentOutput = Apply;
                        c077512.val$outputLiveData.postValue(Apply);
                    }
                }
            }
        }

        public C07751(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.val$workTaskExecutor = taskExecutor;
            this.val$lock = obj;
            this.val$mappingMethod = function;
            this.val$outputLiveData = mediatorLiveData;
        }

        @Override // androidx.view.Observer
        public void onChanged(@Nullable In in) {
            this.val$workTaskExecutor.executeOnBackgroundThread(new AnonymousClass1(in));
        }
    }

    private LiveDataUtils() {
    }

    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C07751(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }
}
