package org.objectweb.asm.commons;

import java.util.Collections;
import java.util.Comparator;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/TryCatchBlockSorter.SCL.lombok */
public class TryCatchBlockSorter extends MethodNode {
    public TryCatchBlockSorter(MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        this(Opcodes.ASM9, methodVisitor, access, name, descriptor, signature, exceptions);
        if (getClass() != TryCatchBlockSorter.class) {
            throw new IllegalStateException();
        }
    }

    protected TryCatchBlockSorter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        super(api, access, name, descriptor, signature, exceptions);
        this.f27600mv = methodVisitor;
    }

    @Override // org.objectweb.asm.tree.MethodNode, org.objectweb.asm.MethodVisitor
    public void visitEnd() {
        Collections.sort(this.tryCatchBlocks, new C129421());
        for (int i = 0; i < this.tryCatchBlocks.size(); i++) {
            this.tryCatchBlocks.get(i).updateIndex(i);
        }
        if (this.f27600mv != null) {
            accept(this.f27600mv);
        }
    }

    /* JADX INFO: renamed from: org.objectweb.asm.commons.TryCatchBlockSorter$1 */
    /* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/TryCatchBlockSorter$1.SCL.lombok */
    class C129421 implements Comparator<TryCatchBlockNode> {
        C129421() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(TryCatchBlockNode tryCatchBlockNode, TryCatchBlockNode tryCatchBlockNode2) {
            return compare2(tryCatchBlockNode, tryCatchBlockNode2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(TryCatchBlockNode tryCatchBlockNode1, TryCatchBlockNode tryCatchBlockNode2) {
            return blockLength(tryCatchBlockNode1) - blockLength(tryCatchBlockNode2);
        }

        private int blockLength(TryCatchBlockNode tryCatchBlockNode) {
            int startIndex = TryCatchBlockSorter.this.instructions.indexOf(tryCatchBlockNode.start);
            int endIndex = TryCatchBlockSorter.this.instructions.indexOf(tryCatchBlockNode.end);
            return endIndex - startIndex;
        }
    }
}
