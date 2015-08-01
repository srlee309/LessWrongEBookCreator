package github.srlee309.lessWrongBookCreator.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Simple helper class to remove all files and sub files in a given directory
 */
public final class DirectoryPurger {
    private static final Logger logger = LoggerFactory.getLogger(DirectoryPurger.class);
    /**
     * Removes all files and subFiles in the given directory
     * @param dir to purge
     * @throws IOException if dir cannot be cleaned
     */
    public void purgeDirectory(File dir) throws IOException {
        if (dir != null && dir.isDirectory()) {
            FileUtils.cleanDirectory(dir);
        }
    }
}
