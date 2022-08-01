import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { NewSkillsComponent } from './components/skills/new-skills.component';
import { EditSkillsComponent } from './components/skills/edit-skills.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent},
  { path: 'editexp/:id', component: EditExperienciaComponent},
  { path: 'nuevaedu', component: NewEducacionComponent},
  { path: 'editedu/:id', component: EditEducacionComponent},
  { path: 'nuevopro', component: NewProyectoComponent },
  { path: 'editpro/:id', component: EditProyectoComponent },
  { path: 'nuevaskill', component: NewSkillsComponent },
  { path: 'editskill/:id', component: EditSkillsComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }