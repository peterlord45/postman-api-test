package com.peter.crud_api.note;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes(){
        return this.noteService.getNotes();
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNote(@RequestBody Note note){
        return noteService.newNote(note);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNotesById(@PathVariable Integer id, @RequestBody Note updatedNote){
        return this.noteService.updateNote(id, updatedNote);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNotesById(@PathVariable Integer id){
        return this.noteService.deleteNote(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNotesById(@PathVariable Integer id){
        return this.noteService.getNoteById(id);
    }

}

