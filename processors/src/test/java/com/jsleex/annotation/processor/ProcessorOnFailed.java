package com.jsleex.annotation.processor;

import com.google.testing.compile.Compilation;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import javax.tools.FileObject;
import java.io.IOException;

public class ProcessorOnFailed extends TestWatcher {
    private Compilation compilation;

    @Override
    protected void failed(Throwable e, Description description) {
        try {
            for (FileObject fo : compilation.generatedFiles()) {
                System.out.println(fo.getCharContent(true));
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void setCompilation(Compilation compilation) {
        this.compilation = compilation;
    }
}
